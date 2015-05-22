(ns clojure-networkinterface.core
  (:import [java.net InetAddress NetworkInterface UnknownHostException SocketException]))

(defn by-index
  "([^Integer idx])
  Get a network interface given its index.
  Returns the NetworkInterface obtained from its index, or null
  if there is no interface with such an index on the system."
  ^NetworkInterface [^Integer idx]
  (NetworkInterface/getByIndex idx))

(defn by-inetaddress
  "([^InetAddress addr])
  Convenience method to search for a network interface
  that has the specified Internet Protocol (IP) address bound to it.
  If the specified IP address is bound to multiple network interfaces
  it is not defined which network interface is returned."
  ^NetworkInterface [^InetAddress addr]
  (NetworkInterface/getByInetAddress addr))

(defn by-name
  "([^String name])
  Searches for the network interface with the specified name."
  ^NetworkInterface [^String name]
  (NetworkInterface/getByName name))

(defn display-name
  "([^NetworkInterface ni])
  Get the display name of this network interface."
  ^String [^NetworkInterface ni]
  (.getDisplayName ni))

(defn hardware-address
  "([^NetworkInterface ni]) Returns a byte[] representing the hardware address.
  ([^NetworkInterface ni & _]) Returns a string formatted Ex: 00-50-F9-D5-01-50
  Returns the hardware address (usually MAC) of the interface
  if it has one and if it can be accessed given the current privileges."
  (^bytes [^NetworkInterface ni]
    (.getHardwareAddress ni))
  (^String [^NetworkInterface ni & _]
    (clojure.string/join "-"
      (map #(format "%02X" %)
        (.getHardwareAddress ni)))))

(defn index
  "([^NetworkInterface ni])
  Returns the index of this network interface."
  ^Integer [^NetworkInterface ni]
  (.getIndex ni))

(defn inet-addresses
  "([^NetworkInterface ni]) returns an java.util.Enumeration
  ([^NetworkInterface ni & _]) Returns an clojure.lang.EnumerationSeq
  Convenience method to return an Enumeration with all or
  a subset of the InetAddresses bound to this network interface.
   Ex: (#<Inet4Address /192.168.19.1> #<Inet6Address
  /fe80:0:0:0:2245:7e3c:e5d2:afc1%eth20>)"
  ([^NetworkInterface ni]
    (.getInetAddresses ni))
  ([^NetworkInterface ni & _]
    (enumeration-seq (.getInetAddresses ni))))

(defn interface-addresses
  "([^NetworkInterface ni])
  Get a List of all or a subset of the InterfaceAddresses
  of this network interface.
  InterfaceAddress represents a Network Interface address.
  In short it's an IP address, a subnet mask and a broadcast
  address when the address is an IPv4 one.
  An IP address and a network prefix length in the case
  of IPv6 address."
  ^java.util.ArrayList [^NetworkInterface ni]
  (.getInterfaceAddresses ni))

(defn mtu
  "([^NetworkInterface ni])
  Returns the Maximum Transmission Unit (MTU) of this interface."
  ^Integer [^NetworkInterface ni]
  (.getMTU ni))

(defn this-name
  "([^NetworkInterface ni])
  Get the name of this network interface."
  ^String [^NetworkInterface ni]
  (.getName ni))

(defn network-interfaces
  "([]) Returns an Enumeration<NetworkInterface>
  ([& _]) Returns an clojure.lang.EnumerationSeq
  Returns all the interfaces on this machine."
  (^java.util.Enumeration []
  (NetworkInterface/getNetworkInterfaces))
  ([& _]
  (enumeration-seq (NetworkInterface/getNetworkInterfaces))))

(defn parent
  "([^NetworkInterface ni])
  Returns the parent NetworkInterface of this interface
  if this is a subinterface, or null if it is a physical
  (non virtual) interface or has no parent."
  ^NetworkInterface [^NetworkInterface ni]
  (.getParent ni))

(defn subinterfaces
  "([]) Returns an Enumeration<NetworkInterface>
  ([& _]) Returns an clojure.lang.EnumerationSeq
  Get an Enumeration with all the subinterfaces
  (also known as virtual interfaces) attached
  to this network interface."
  ([^NetworkInterface ni]
  (.getSubInterfaces ni))
  ([^NetworkInterface ni & _]
  (enumeration-seq (.getSubInterfaces ni))))

(defn loopback?
  "([^NetworkInterface ni])
  Returns whether a network interface is a loopback interface."
  ^Boolean [^NetworkInterface ni]
  (.isLoopback ni))

(defn pointtopoint?
  "([^NetworkInterface ni])
  Returns whether a network interface is a point to point interface."
  ^Boolean [^NetworkInterface ni]
  (.isPointToPoint ni))

(defn up?
  "([^NetworkInterface ni])
  Returns whether a network interface is up and running."
  ^Boolean [^NetworkInterface ni]
  (.isUp ni))

(defn virtual?
  "([^NetworkInterface ni])
  Returns whether this interface is a virtual interface (also called subinterface)."
  ^Boolean [^NetworkInterface ni]
  (.isVirtual ni))

(defn supportsmulticast?
  "([^NetworkInterface ni])
  Returns whether a network interface supports multicasting or not."
  ^Boolean [^NetworkInterface ni]
  (.supportsMulticast ni))
