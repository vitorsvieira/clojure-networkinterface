(ns clojure-networkinterface.core-test
  (:require [clojure.test :refer :all]
            [clojure-networkinterface.core :refer :all :reload-all :true])
  (:import (java.net NetworkInterface)))

(deftest networkinterface-test-static
  (is (true? (instance? NetworkInterface (by-index 1))))
  (is (true? (instance? NetworkInterface (by-inetaddress (first (inet-addresses (by-index 1) :ips))))))
  (is (true? (instance? NetworkInterface (by-name (this-name (by-index 1))))))
  (is (instance? java.util.Enumeration (network-interfaces)))
  (is (instance? clojure.lang.EnumerationSeq (network-interfaces :seq))))

(deftest networkinterface-test-flags
  (let [nic (by-index 1)]
    (is (true? (instance? Boolean (loopback? nic))))
    (is (true? (instance? Boolean (pointtopoint? nic))))
    (is (true? (instance? Boolean (up? nic))))
    (is (true? (instance? Boolean (virtual? nic))))
    (is (true? (instance? Boolean (supportsmulticast? nic))))))


(deftest networkinterface-test-publics
  (let [nic (by-name "eth3")]
    (is (true? (instance? String (display-name nic))))
    (is (true? (instance? (type (byte-array 10)) (hardware-address nic))))
    (is (true? (instance? String (hardware-address nic :formatted))))
    (is (true? (instance? Integer (index nic))))
    (is (true? (instance? java.util.Enumeration (inet-addresses nic))))
    (is (true? (instance? clojure.lang.EnumerationSeq (inet-addresses nic :formatted))))
    (is (true? (instance? java.util.ArrayList (interface-addresses nic))))
    (is (true? (instance? Integer (mtu nic))))
    (is (true? (instance? String (this-name nic))))
    (is (or (true? (instance? NetworkInterface (parent nic))) nil?))
    (is (or (true? (instance? java.util.Enumeration (subinterfaces nic))) nil?))
    (is (or (true? (instance? clojure.lang.EnumerationSeq (subinterfaces nic))) nil?))))

