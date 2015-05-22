(defproject clojure-networkinterface "0.1.0-SNAPSHOT"
  :description "Clojure NetworkInterface. java.net.NetworkInterface class wrapper."
  :url "https://github.com/notvitor/clojure-networkinterface"
  :license {:name "The MIT License (MIT)"}
  :min-lein-version "2.5.1"
  :test-selectors {:default (fn [v] (not (:time-consuming v))),
                   :time-consuming (fn [v] (:time-consuming v)),
                   :focus (fn [v] (:focus v)),
                   :all (fn [_] true)}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :warn-on-reflection false)
