@Library('shared-library') _

pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo "✓ Código descargado - Rama: ${env.BRANCH_NAME}"
            }
        }
        
        stage('Validación por Rama') {
            steps {
                script {
                    echo """
                    ╔═══════════════════════════════════════════╗
                    ║   INICIANDO VALIDACIÓN                    ║
                    ║   Rama: ${env.BRANCH_NAME}                ║
                    ╚═══════════════════════════════════════════╝
                    """
                    
                    // Lista de ramas excepcionadas (opcional)
                    def excepciones = ['feature/hotfix-urgente']
                    
                    // El validador decide qué ejecutar según la rama
                    validadorPipeline(
                        branch: env.BRANCH_NAME,
                        exceptionList: excepciones
                    )
                }
            }
        }
        
        stage('Deploy (según rama)') {
            steps {
                script {
                    if (env.BRANCH_NAME == 'develop') {
                        echo "🚀 Desplegando a entorno de desarrollo..."
                        // sh './scripts/deploy-dev.sh'
                    } else if (env.BRANCH_NAME == 'master' || env.BRANCH_NAME == 'main') {
                        echo "🚀 Listo para desplegar a producción"
                        // input message: '¿Desplegar a producción?', ok: 'Desplegar'
                        // sh './scripts/deploy-prod.sh'
                    }
                }
            }
        }
    }
    
    post {
        success {
            echo '🎉 Pipeline completado exitosamente'
        }
        failure {
            echo '❌ Pipeline falló'
        }
        always {
            echo '🧹 Limpieza completada'
        }
    }
}
