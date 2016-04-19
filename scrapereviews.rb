require 'rubygems'
require 'oauth'
require 'rexml/document'
require 'cgi'
include REXML


#extract title from .mobi filename inlcuding author and filetype
def strip_string(newString)
	#split string up using '-'
	splitStringArray = newString.split(' - ')
	length = splitStringArray.length
	author = splitStringArray[0]
	booktitle = splitStringArray[length-1]
	#strip '.mobi\n' or '.prc\n' from end of string
	if booktitle.include?".prc"
		strippedbooktitle = booktitle.split(".prc")
	else 
		strippedbooktitle = booktitle.split(".mobi")
	end
	#switch strings on each side of comma
	authorArray = author.split(", ")
	firstname = authorArray[authorArray.length - 1]
	lastname = authorArray[0]
	#combine to form full author name
	authorname = firstname+" "+lastname
	#return author fullname and title
	return strippedbooktitle[0], authorname
end

def get_book_xml(bookauthor, booktitle, strippedtitle)
	#access goodreads api to collect xml file with book details
	if bookauthor == nil
		uri = URI.parse 'http://www.goodreads.com/book/title.xml?&key=lHrmjpymqnxvcGCBYq6g&title='+booktitle
		response = Timeout::timeout(600) { Net::HTTP.get(uri) }
	else
		uri = URI.parse 'http://www.goodreads.com/book/title.xml?author='+bookauthor+'&key=lHrmjpymqnxvcGCBYq6g&title='+booktitle
		response = Timeout::timeout(30) { Net::HTTP.get(uri) }
	end
	#output xml file to author.xml
	bookXML = strippedtitle+".xml"
	outputFile = File.open(bookXML, 'w')
	outputFile.write(response)
	outputFile.close

	return bookXML
end

def get_working_xmldoc(strippedtitle, author)
	#encode book title and author name for search url
	booktitle = CGI::escape(strippedtitle)
	if author == nil
		bookXML = get_book_xml(nil, booktitle, strippedtitle)
	else
		bookauthor = CGI::escape(author)
		bookXML = get_book_xml(bookauthor, booktitle, strippedtitle)
	end

	#create new xml object using contents of title.xml
	xmlFile = File.new(bookXML)
	xmldoc = Document.new(xmlFile)
	
	#if book + author could not get result, try book with no author
	if XPath.first(xmldoc, "//book/title") == nil
		xmlFile.close
		
		#create new xmlFile with results of search without author
		bookXML = get_book_xml(nil, booktitle, strippedtitle)		
		
		xmlFile = File.new(bookXML)
		xmldoc = Document.new(xmlFile)
		
		#if this still produces no result, list name of book and move on to next book
		if XPath.first(xmldoc, "//book/title") == nil
			print "Could not find "+strippedtitle +" "+author+"\n"
			xmldoc = nil
		end		
	end
	xmlFile.close
	return xmldoc
end

def add_to_database(outputString, database)
	database.write(outputString)
end

def print_greeting_get_choice
	print "Greetings User. How would you like to search for your books? (Enter A or B)\n"
	print "\tA. Type in book info\n"
	print "\tB. Get book info from text file\n>"
	
	choice = STDIN.gets.chomp()
	choice.downcase!
	return choice
end

def validate_choice(userchoice, choice1, choice2)
	userchoice.downcase!
	validchoice = false
	if userchoice.eql?(choice1)  || userchoice.eql?(choice2) 
		validchoice = true
	end
	return validchoice
end

def get_output_choice
	print "How would you like your information displayed? (Enter A or B)\n"
	print "\tA. Printed out in current display\n"
	print "\tB. Output file\n>"
	
	choice = STDIN.gets.chomp()
	choice.downcase!
	return choice
end

def add_to_output(xmldoc, outputchoice, database, outputstring)
	if outputchoice.eql?("a")
		outputstring = outputstring+ "\nBook:"
		outputstring = outputstring+	"\n\tTitle - " + XPath.first(xmldoc, "//book/title").text.delete(",")
		outputstring = outputstring+	"\n\tAuthor - " + XPath.first(xmldoc, "//book/authors/author/name").text.delete(",")
		outputstring = outputstring+	"\n\tRatings Count - " + XPath.first(xmldoc, "//book/work/ratings_count").text
		outputstring = outputstring+	"\n\tAverage Rating - " + XPath.first(xmldoc, "//book/average_rating").text
		outputstring = outputstring+	"\n\tNumber of Pages - " + XPath.first(xmldoc, "//book/num_pages").text
		outputstring = outputstring+ "\nEnd of Book\n"
		return outputstring
	else
		datatitle = XPath.first(xmldoc, "//book/title").text.delete(",")
		add_to_database(datatitle + ",", database)
		dataauthor = XPath.first(xmldoc, "//book/authors/author/name").text.delete(",")
		add_to_database(dataauthor + ",", database)
		add_to_database(XPath.first(xmldoc, "//book/work/ratings_count").text + ",", database)
		add_to_database(XPath.first(xmldoc, "//book/average_rating").text + ",", database)
		add_to_database(XPath.first(xmldoc, "//book/num_pages").text + "\n", database)
	end
end

def add_to_cache(xmldoc)
	cache = File.open("cache", 'a')
	cache.write(xmldoc)
end

def get_books_from_user(outputchoice, database, outputstring)
entry = ""
books = ""
	while (0)
		print "\nType out the title and author of the book. If you do not know the author,\nplease leave the field blank"
		print "\nType out as many books as you are want. When you are finished, simply type\nout ""done"""
		print "\nTitle: "
		entry = STDIN.gets.chomp()
		if entry.eql?("done")
			break
		end
		books = books + entry + "~"
		print "Author: "
		entry = STDIN.gets.chomp()
		books = books + entry + "\n"
	end
	
	bookinfo = books.split("\n")
	bookinfo.each { |bookinfo|
		title, author = bookinfo.split("~")
		xmldoc = get_working_xmldoc(title, author)
		
		if xmldoc == nil
			next
		else
			#add_to_cache(xmldoc)
			outputstring = add_to_output(xmldoc, outputchoice, database, outputstring)
		end
	}
	
	return outputstring
end

def get_books_from_file(outputchoice, database, outputstring)
	print "\nPlease enter the name of the file with the list of books\n>"
	bookfilename = STDIN.gets.chomp()
	while !File.exists?(bookfilename)
		print "\nNo Such File.\nPlease enter the name of the file with the list of books\n>"
		bookfilename = STDIN.gets.chomp()
	end
	booktitle_file = File.open(bookfilename, 'r')
	
	#for every entry in the book
	while !booktitle_file.eof?
		#extract author's last name and book title
		strippedtitle, author =  strip_string(booktitle_file.readline())
		
		xmldoc = get_working_xmldoc(strippedtitle, author)
		
		if xmldoc == nil
			next
		else
			#add_to_cache(xmldoc)
			outputstring = add_to_output(xmldoc, outputchoice, database, outputstring)
		end
	end
	booktitle_file.close
	return outputstring
end

####################################################MAIN PROGRAM#########################################################

#Get user input preference
inputchoice = print_greeting_get_choice
while !validate_choice(inputchoice,"a", "b")
	print "Invalid Choice. Please choose again.\nHow would you like to search for your book info? (Enter A or B)\n>"
	inputchoice = print_greeting_get_choice
end

#Get user output preference
outputchoice = get_output_choice
while !validate_choice(outputchoice,"a", "b")
	print "Invalid Choice. Please choose again.\nHow would you like your information displayed? (Enter A or B)\n>"
	outputchoice = get_output_choice
end

if outputchoice.eql?("a")
	outputstring = " "
else
	database = File.open("database.csv", 'w')
	database.write("Title,Author,Ratings_Count,Average_Rating,Number_Of_Pages\n")
end

if inputchoice.eql?("a")
	outputstring = get_books_from_user(outputchoice, database, outputstring)
else
	outputstring = get_books_from_file(outputchoice, database, outputstring)
end

if outputchoice.eql?("a")
	print outputstring
else
	database.close
end
