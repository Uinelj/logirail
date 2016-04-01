# Données

_Ce document est destiné aux administrateurs système et aux services informatique de maintenance qui sont amenés à déployer des mises à jour du produit._

Logirail a besoin d'une base de fichiers de données afin de fonctionner. Ces fichiers sont à placer au même endroit que l'exécutable, et sont au format `JSON`.
Les données contiennent de nombreuses informations, détaillées ici, en anglais.

## JSON Specification

In this folder you will find all the data used by the Logirail software.
All our data are stored onto JSON files, because of their quite static nature.

### cantons.json

Each entry represents a Canton, which has a `length` and a unique `id`.

```json

{
  "cantons": [
      {
          "lenght": "100",
          "id":"0"
      }
  ]
}
```

### gare.json

Each station (Gare) entry has an id, used by the engine, and a name, used by the GUI to display its name.

```json

{
  "gares": [
      {
          "name": "Cergy-Le-Haut",
          "id":"0"
      }
  ]
}
```

### incident.json

An incident entry has a type, which will be displayed by the GUI, an id which correlates with its type, and a time interval, which represents the amount of time the incident will last.

```json
{
	"Incident": [
		{
			"Type":"Person Incident",
			"Id":"1",
			"Min_Time":"30",
			"Max_Time":"120"
		}
  ]
}

```

### ligne.json

Line is the joint between Cantons and stations (Gare) : It takes a canton and links two stations by their ID. `in` will represent the station before the canton, and `out` will represent the station after.

```json
{
    "line": [

    {
    	"in" : "0",
    	"cantons" : [0],
    	"out" : "1"
    }
  ]
}
```

### missioncodes.json

Links a meaningless `missionCode` (like `UBAL`, `TEDI`, etc.) to its route, referring to the stations' id.
```json
{
  "missioncodedatabase"  : {
    "UBAL" : {
      "name" : "UBAL",
      "road" : [24, 23, 22, 21, 20, 19, 11, 10, 9, 5, 4, 3, 2, 1, 0]
    }
  }
}

```

### schedule.json

Indicates the theoreitical hours of departure of trains, by their `missionCode`. Each scheduled depature time is separated by a `;`.

```json

{
	"Schedules": [
    {
      "MissionCode":"TEDI",
      "schedules":"05:51:00;06:16:00;09:23:00;09:42:00;10:02:00"
    }
  ]
}

```

### trainmodel.json

Database of tran models. Not very useful on its own, but it could be used to add some informations following the model, like the age of the train, the average/maximal speed, etc.

```json

{
	"train": [
		{
			"model":"MS61",
		}
  ]
}

```
