mongoBeans
==========

A small Xtext-based DSL providing JavaBeans access to mongoDB entries

MongoDB is a very popular document-based database management system. The standard Java driver 
allows to manipulate mongoDB entries as hash maps. This results in two major annoyances
1) you loose Java's static typing and
2) constructing a grph of nested hash maps is pretty inconvenient in Java.

In this project, we have created a small DSL based on Xtext[1] that allows to create basic entity 
classes that are backed by mongoDB objects but provide a statically typed JavaBeans API. In 
addition, we offer a nice builder API to significantly simplify the creation of such entities 
when using the JVM language Xtend[2].

Links:

[1] www.xtext.org

[2] www.xtend-lang.org