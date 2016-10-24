(ns phone-number)

(def phone-number-length 10)
(def bad-number (apply str (repeat phone-number-length "0")))

(defn- phone-with-us-or-ca-country-code? [digits]
  (and (= (count digits) (+ phone-number-length 1))
       (= (subs digits 0 1) "1")))

(defn- clean-non-numeric [phone-number]
  (.replaceAll phone-number "[^0-9]" ""))

(defn- without-country-code [digits]
  (subs digits 1))

(defn number [phone-number]
  (let [digits (clean-non-numeric phone-number)]
    (cond
      (= (count digits) phone-number-length) digits
      (= (phone-with-us-or-ca-country-code? digits) true) (without-country-code digits)
      :else bad-number)))

(defn area-code [phone-number]
  (subs (number phone-number) 0 3))

(defn- exchange [phone-number]
  (subs (number phone-number) 3 6))

(defn- subscriber [phone-number]
  (subs (number phone-number) 6))

(defn pretty-print [digits]
  (format "(%s) %s-%s" (area-code digits) (exchange digits) (subscriber digits)))



