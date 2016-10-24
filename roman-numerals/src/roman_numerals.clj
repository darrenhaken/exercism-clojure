(ns roman-numerals)

;Sort map descending to avoid having to deal with smaller char supercedes a bigger one.
(def arabic->roman-desc (sorted-map-by > 1000 "M" 900 "CM" 500 "D" 400 "CD"
                                                 100 "C" 90 "XC" 50 "L" 40 "XL"
                                                 10 "X" 9 "IX" 5 "V" 4 "IV"
                                                 1 "I"))

(defn next-number-greater-than [currentNumber]
  (some #(when (>= currentNumber (first %)) %) arabic->roman-desc))

(defn numerals [arabic]
  (loop [currentNumber arabic, numerals []]
    (if (zero? currentNumber)
      (apply str numerals)
      (let [[arabicKey romanValue] (next-number-greater-than currentNumber)]
        (recur (- currentNumber arabicKey) (conj numerals romanValue))))))