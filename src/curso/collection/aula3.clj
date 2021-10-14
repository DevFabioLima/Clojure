(ns curso.collection.aula3
  (:require
    [curso.collection.db :as c.db]))

; (println (c.db/todos-os-pedidos))

; (println (group-by :usuario (c.db/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario elemento))

; (println (group-by minha-funcao-de-agrupamento (c.db/todos-os-pedidos)))

; {15 []
;   1 []
;  10 []
;  20 []}

; (println (map count (vals (group-by :usuario (c.db/todos-os-pedidos)))))

(->> (c.db/todos-os-pedidos)
     (group-by :usuario)
     vals
     (map count)
     println)

(defn conta-total-por-usuario
  [[usuario pedidos]]
  {:usuario usuario
   :total-de-pedidos (count pedidos)})

(->> (c.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario))

(println "PEDIDOS")

(defn total-do-item
  [[_ detalhes]]
  (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       (map total-do-item)
       (reduce +)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantia-de-pedidos-e-gastos-total-por-usuario
  [[usuario pedidos]]
  {:usuario usuario
   :total-de-pedidos (count pedidos)
   :preco-total (total-dos-pedidos pedidos)})

(->> (c.db/todos-os-pedidos)
     (group-by :usuario)
     (map quantia-de-pedidos-e-gastos-total-por-usuario)
     println)
