(:Ejercicio 1: Obtener el nombre de los puertos de Italia.:)

for $i in doc("puertos.xml")/puertos/puerto where $i/pais='Italia' 
return <puerto>{$i/nombre}</puerto>

(:Ejercicio 2: Obtener el número de puertos de España.:)

for $i in doc("puertos.xml")/puertos
let $c :=  $i/puerto[pais='España']
return <NumeroDePuertosEnEspaña>{count($c)}</NumeroDePuertosEnEspaña>

(:Ejercicio 3: El nombre y el recorrido de los cruceros que se organizan cada mes,
con un precio base superior seiscientos euros ordenados por su nombre.:)

for $i in doc("cruceros.xml")/cruceros/crucero 
where $i/frecuencia='cada_mes' and $i/precio/base > 600
order by $i/nombre
return <crucero>{$i/nombre}{$i/recorrido}</crucero>

(:Ejercicio 4: El nombre y el número de etapas de los cruceros que se organizan “cada_dos_meses”:)

for $i in doc("cruceros.xml")/cruceros/crucero 
where $i/frecuencia='cada_dos_meses'
let $num :=  $i/recorrido/etapa 
return <crucero>{$i/nombre}<numero_de_etapas>{count($num)}</numero_de_etapas></crucero>

(:Ejercicio 5: El nombre del crucero, el del puerto de salida y el precio de un camarote exterior
(que se calcula añadiendo al precio base, el precio extra por un camarote exterior) de aquellos 
cruceros que paran o salen de la ciudad de Bari:)

for $i in doc("cruceros.xml")/cruceros/crucero 
where $i/recorrido/puerto_salida='Bari' or $i/recorrido/etapa/puerto='Bari'
return <crucero>
                {$i/nombre}{$i/recorrido/puerto_salida}
                <precio_en_camarote_exterior>{$i/precio/extra_camarote_exterior + $i/precio/base}</precio_en_camarote_exterior>
       </crucero>

(:Ejercicio 6: El nombre del crucero, el del puerto de salida y el número total de días de duración de los
cruceros que tienen su salida en un puerto de España:)

for $i in doc("cruceros.xml")//crucero, $j in doc("puertos.xml")//puerto[pais='España']
where $i/recorrido/puerto_salida = $j/nombre
return <crucero>
                {$i/nombre}{$i/recorrido/puerto_salida}
                <dias_crucero>{sum($i/recorrido/etapa/dias)}</dias_crucero>
       </crucero>
