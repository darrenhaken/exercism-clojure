(ns triangle)

(defn type [a b c]
  (let [illogical? #(or (<= (+ a b) c)
                        (<= (+ b c) a)
                        (<= (+ c a) b))
        equilateral? #(= a b c)
        isosceles? #(or (= a b)
                        (= b c)
                        (= a c))]
    (cond
      (illogical?) :illogical
      (equilateral?) :equilateral
      (isosceles?) :isosceles
      :else :scalene)))