(ns beer-song
  (:gen-class)
  (:require [clojure.string :as str]))

(def empty-verse
  (str "No more bottles of beer on the wall, no more bottles of beer.\n"
       "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))

(def one-bottle-verse
  (str "1 bottle of beer on the wall, 1 bottle of beer.\n" "Take it down and pass it around, no more bottles of beer on the wall.\n"))

(def two-bottles-verse
  (str "2 bottles of beer on the wall, 2 bottles of beer.\n"
       "Take one down and pass it around, 1 bottle of beer on the wall.\n"))

(def multiple-bottles-line
  (str "%s bottles of beer on the wall, %s bottles of beer.\n" "Take one down and pass it around, %s bottles of beer on the wall.\n"))

(defn- multiple-lines [verse-number]
  (format multiple-bottles-line verse-number verse-number (dec verse-number)))

(defn verse [verse-number]
  (cond
    (= verse-number 2) two-bottles-verse
    (= verse-number 1) one-bottle-verse
    (zero? verse-number) empty-verse
    :else (multiple-lines verse-number)))

(defn sing
  ([from] (sing from 0))
  ([from to]
   (if (= from to)
     (apply str (verse from))
     (str/join "\n" [(verse from) (sing (dec from) to)]))))