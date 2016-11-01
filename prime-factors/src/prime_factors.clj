(ns prime-factors)

(defn- no-remainder? [number candidate]
  (zero? (rem number candidate)))

(defn of
  ([number]
   (of number 2 []))
  ([number divisor accumulator]
   (cond
     (<= number 1) accumulator
     (no-remainder? number divisor) (recur (/ number divisor) divisor (conj accumulator divisor))
     :else (recur number (inc divisor) accumulator))))
