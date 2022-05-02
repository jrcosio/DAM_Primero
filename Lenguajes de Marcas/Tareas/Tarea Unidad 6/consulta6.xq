(:Ejercicio 6: El nombre del crucero, el del puerto de salida y el número total de días de duración de los
cruceros que tienen su salida en un puerto de España:)

for $i in doc("cruceros.xml")//crucero, $j in doc("puertos.xml")//puerto[pais='España']
where $i/recorrido/puerto_salida = $j/nombre
return <crucero>
                {$i/nombre}{$i/recorrido/puerto_salida}
                <dias_crucero>{sum($i/recorrido/etapa/dias)}</dias_crucero>
       </crucero>