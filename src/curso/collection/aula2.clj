(ns curso.collection.aula2)

;["Fabio", "Lucas", "Martins", "Da Silva", "Lima"]

(defn conta
  [total-ate-agora elementos]
  (recur (inc total-ate-agora) (rest elementos)))

; (println (conta 0 ["Fabio", "Lucas", "Martins", "Da Silva", "Lima"])) crash sem cond de parada

(defn conta
  [total-ate-agora elementos]
  (if (next elementos)
    (recur (inc total-ate-agora) (rest elementos))))

; (println (conta 0 ["Fabio", "Lucas", "Martins", "Da Silva", "Lima"])) nil, n retornei nada no else

(defn conta
  [total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (rest elementos))
     total-ate-agora))

(println (conta 0 ["Fabio", "Lucas", "Martins", "Da Silva", "Lima"]))
(println (conta 0 []))

(defn minha-funcao
  ([parametro1] (println "p1" parametro1))
  ([parametro1 parametro2]
   (println "p1" parametro1)
   (println "p2" parametro2)))

(minha-funcao 1)
(minha-funcao 1 2)

(defn conta
  ([elementos] (conta 0 elementos))
  ([total-ate-agora elementos]
   (if (seq elementos)
     (recur (inc total-ate-agora) (rest elementos))
     total-ate-agora)))

(println (conta 0 ["Fabio", "Lucas", "Martins", "Da Silva", "Lima"]))
(println (conta 0 []))


; Utilizando o loop

(defn conta-loop
  [elementos]
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc total-ate-agora) (next elementos-restantes))
      total-ate-agora)))

(println "loop" (conta-loop ["Fabio", "Lucas", "Martins", "Da Silva", "Lima"]))
(println (conta 0 []))