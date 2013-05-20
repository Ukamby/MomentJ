MomentJ
=======

A Java port of the open source JavaScript library MomentJS

Goals
-----
To build a Java library for dates and times that just works as you want it to.

Following the excellent example of an API for dates and times Tim Wood built with MomentJS and attempting to recreate the same experience in a natural way in Java.

Make it really, really easy to:
- get dates in, whatever format you've got we'll take it
- manipulate dates - add or substract any kind of time period
- write dates out, in whatever format, language and time zone you'd like

Out of Scope
------------
Building a high precision timer (milliseconds are as low as we go).

Caching your values safely across thread boundaries. We're mutable, deal with it.
