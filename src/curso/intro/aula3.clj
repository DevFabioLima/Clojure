(ns curso.aula3)


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(valor-descontado 1000)

(valor-descontado 100)

(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(valor-descontado 1000)


(defn aplica-desconto?
  [valor-bruto]
  (println "Nova versão com when")
  (when (> valor-bruto 100)
    true))

(println (valor-descontado 1000))

(defn aplica-desconto?
  [valor-bruto]
  (println "Nova versão direta")
  (> valor-bruto 100))

(println (valor-descontado 10))

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado mais-caro-que-100? 1000))


(println "Arrow functions")

(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 100))

(println "Abreviando ainda mais um arrow function")

(println (valor-descontado #(> % 100) 100))

(println "Definindo um nome para uma arrow function")

(def mais-caro-que-100? #(> % 1000))

(println (valor-descontado mais-caro-que-100? 1000))




















