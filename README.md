clojure-networkinterface
--------------

[![Build Status](https://travis-ci.org/notvitor/clojure-networkinterface.svg?branch=master)](https://travis-ci.org/notvitor/clojure-networkinterface)

Clojure NetworkInterface. java.net.NetworkInterface class wrapper.


## Usage

Get network interface by name:

    => (by-name "eth3")
    #<NetworkInterface name:eth3 (Intel(R) 82579LM Gigabit Network Connection)>

Get list of network interfaces as an Enumeration<NetworkInterface> with:

    => (network-interfaces)
    #<java.net.NetworkInterface$2@1f1b62ff>

Get list of network interfaces as an EnumerationSeq with:

    => (network-interfaces :opts)
    #(#<NetworkInterface name:lo (Software Loopback Interface 1)> #<NetworkInterface name:net0 (WAN Miniport (SSTP))>...#<NetworkInterface name:eth3          (Intel(R) 82579LM Gigabit Network Connection)> #<NetworkInterface name:wlan0 (Dell Wireless 1504 802.11b/g/n (2.4GHz))>...

Get the Inet Addresses from network interface as an EnumerationSeq with:

    => (inet-addresses (by-name "wlan0") :ips)
    #(#<Inet4Address /192.168.100.3> #<Inet6Address /fe80:0:0:0:c52d:8f2f:2bfc:f120%wlan0>)

Check if network interface is up and running with:

    => (up? (by-name "wlan0"))
    true

Check if network interface is a loopback interface with:

    => (loopback? (by-name "lo"))
    true


For more examples and full documentation check the link below.

##Reference and Doc:

[NetworkInterface](https://docs.oracle.com/javase/7/docs/api/java/net/NetworkInterface.html).
---

Have a request, suggestion or question?

Drop me an email: vitorsvieira at yahoo.com

You can also find me at [@notvitor](https://twitter.com/notvitor)


---

### License

The MIT License (MIT)

Copyright (c) 2015 Vitor Vieira

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
