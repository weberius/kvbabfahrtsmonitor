# KVB Abfahrtsmonitor

Das KVB Abfahrtsmonitor liest zu einer angefragten Haltestelle die Abfahrtszeiten ein und formatiert sie in eine JSON-Struktur, die einfach auf einer Webseite angezeigt werden kann. Grundlage hierfür ist der [Widget Generator](http://www.kvb-koeln.de/generator/) der [Kölner Verkehrsbetriebe](http://www.kvb-koeln.de/).

# Entwicklungsstand

Dieses Projekt befindet sich in der Entwicklung

# Verwendete Technologien/ Bibliotheken

- Java
- [jsoup](https://jsoup.org/)

# Schnittstellen

## /kvbabfahrtsmonitor/service/stop/{id}

Dieses Schnittstelle stellt die aktuellen Abfahrtszeiten für die Haltestelle {id} zur Verfügung.

Beispiel (Neumarkt):
[/publicTransportDepartureTimeCologne/service/stop/2](https://tom.cologne.codefor.de/publicTransportDepartureTimeCologne/service/stop/2)

## /kvbabfahrtsmonitor/service/stop/{id}?datatables

Dieses Schnittstelle stellt die aktuellen Abfahrtszeiten für die Haltestelle {id} zur Verfügung. Die Rückgabe ist für die Verwendung der javascript Bibliothek datatables optimiert.

Beispiel (Neumarkt):
[/publicTransportDepartureTimeCologne/service/stop/2?datatables](https://tom.cologne.codefor.de/publicTransportDepartureTimeCologne/service/stop/2?datatables)



# Installation

1. Checkout Sources
2. Build Application
3. Deploy Application

## License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.
