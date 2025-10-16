# Mi Proyecto con Jenkins Pipeline

Proyecto de ejemplo que utiliza la Shared Library de Jenkins para validaciones.

## Ramas

- **main/master**: Todas las validaciones (Kiuwan + Unitarias + Regresión)
- **develop**: Pruebas unitarias según pom.xml
- **feature/***: Solo análisis Kiuwan

## Configuración

- `Jenkinsfile`: Define el pipeline
- `pom.xml`: Controla ejecución de tests (`<skipTests>`)
- `pipeline-config.json`: Configuración de excepciones

## Uso

1. Subir este repositorio a Git
2. Crear Multibranch Pipeline en Jenkins
3. Jenkins automáticamente detectará las ramas y aplicará las validaciones
