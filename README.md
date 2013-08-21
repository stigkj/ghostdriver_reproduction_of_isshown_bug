Provoke error in isShown in get_text (web atoms)
================================================

Setup
-----

**Prerequisites:**

* *Ruby >= 1.9*
* *Groovy >= 1.8*

**Install Ruby dependencies**

    bundle install


Run it
------

1. Start the web server listening on default port 4567

        bundle exec ./web_server.rb

2. Run phantomjs in webdriver mode listening on default port 8910,
   either with the embedded ghostdriver or using an external version
   * `phantomjs --webdriver=8910`
   * `phantomjs <path to main.js>`

3. Run the driver groovy script

        groovy drive_phantomjs.groovy


When successful, the driver script should print the text 'should return this' on the console.

NB! The driver script should download dependencies by it self, courtesy of Groovy's Grape.
    If this does not work, try to clear your local Maven repository.
