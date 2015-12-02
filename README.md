# JavaEmailTemplateBuilder

Mamute QA [![Build Status](https://secure.travis-ci.org/caelum/mamute.png)](http://travis-ci.org/caelum/mamute)
======

##How to set up an instance of mamute

First of all, you need to setup an MySQL database. The default database name is 
`mamute_development`, the username is `root` and the password must be blank.

##To use mamute

###Using a compiled war file:

1. Download the war of the latest version at http://www.mamute.org
2. Unpack it to a folder named `yourproject/mamute`
3. Run it by executing the bash script `mamute/run.sh`
4. If everything worked, you are free to customize `mamute` folder as you want to! 

###Using git + maven:

1. Clone the repository from [github](https://github.com/caelum/mamute)
2. Install node and npm
3. Run `npm install`
5. Run `npm install -g grunt-cli`
6. Run `./scripts/mvn-package.sh`
7. Make a copy of `mamute/target/mamute-1.0.0-SNAPSHOT` to `yourproject/mamute`
8. Run it by executing the bash script `mamute/run.sh`
9. If everything worked, you are free to customize `mamute` folder as you want to! 

##To contribute with mamute:

1. Fork the repository from [github](https://github.com/caelum/mamute)
2. Clone the fork
3. Install node and npm
4. Run `npm install`
5. Run `npm install -g grunt-cli`
6. Run `Main.java` to start mamute
7. Develop and do your pull request

##FAQ

* [How to setup an instance](http://meta.mamute.org/221-how-to-set-up-an-instance-of-mamute)
