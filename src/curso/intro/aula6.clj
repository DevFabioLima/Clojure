(ns curso.aula6)

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15
  [valor]
  (println "valor" (class valor) valor) 15)

(println (map imprime-e-15 pedido))

; Destruct
(defn imprime-e-15
  [[chave valor]]
  (println chave "<e>" valor) 15)

(println (map imprime-e-15 pedido))

(defn imprime-e-15
  [[chave valor]]
  valor)

(println (map imprime-e-15 pedido))

(defn preco-dos-produtos
  [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (reduce + (map preco-dos-produtos pedido)))

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

(println (total-do-pedido pedido))



; THREADING LAST
(defn total-do-pedido
  [pedido]
  (->> pedido
       (map preco-dos-produtos ,,)
       (reduce + ,,)))

(println (total-do-pedido pedido))


(defn preco-total-do-produto
  [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto ,,)
       (reduce + ,,)))

(println (total-do-pedido pedido))


(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 90}
             :chaveiro {:quantidade 5}})

(defn gratuito?
  [[_ item]]
  (<= (get item 0) 0))

(prinln "Filtrando precos")
(println (filter gratuito? preco))


(defn gratuito?
  [item]
  (<= (get item 0) 0))

(prinln "Filtrando precos")
(println (filter (fn [[chave item]] (gratuito? item)) pedido))

(println (filter #( (gratuito? (second %))) pedido))


(defn pago?
  [item]
  (not (gratuito? item)))

(println (gratuito? {:preco 50}))
(println (gratuito? {:preco 0}))

(println ((comp not gratuito?) {:preco 10}))

(def pago? (comp not gratuito?))

(println (pago? :preco 10))


















