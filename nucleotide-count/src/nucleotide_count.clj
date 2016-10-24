(ns nucleotide-count)

(def dna-nucleotides #{\A \T \C \G})
(def rna-nucleotides #{\U})
(def all-nucleotides (set (concat rna-nucleotides dna-nucleotides)))

(defn valid-nucleotide? [nucleotide]
  "Check if this a valid rna/dna nucleotide"
  (contains? all-nucleotides nucleotide))

(defn filter-dna-on [nucleotide dna]
  (filter #(= nucleotide %) dna))

(defn count [nucleotide dna]
  "Count the number of nucleotide occurence in the dna strand"
  (if (valid-nucleotide? nucleotide)
    (clojure.core/count (filter-dna-on nucleotide dna))
    (throw (Exception. "invalid nucleotide"))))

(defn nucleotide-counts [dna]
  "Count the number of nucleotides in the dna"
  (reduce into (map (fn [nucleotide] {nucleotide (count nucleotide dna)}) dna-nucleotides)))
