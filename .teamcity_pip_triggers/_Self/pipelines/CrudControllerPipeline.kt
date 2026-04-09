package _Self.pipelines

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object CrudControllerPipeline : Pipeline({
    name = "Crud Controller: pipeline"

    repositories {
        repository(DslContext.settingsRoot)
    }

    triggers {
        vcs {
            branchFilter = ""
        }
    }

    job(CrudControllerPipeline_Job1)
})

object CrudControllerPipeline_Job1 : Job({
    id("Job1")
    name = "Job: CMD"

    steps {
        script {
            name = "Echo"
            scriptContent = "echo 'CRUD'"
        }
    }
})
