package _Self.pipelines

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object CrudControllerPipeline : Pipeline({
    name = "CRUD Controller: pipeline"

    repositories {
        repository(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }

    job(CrudControllerPipeline_Job1)
})

object CrudControllerPipeline_Job1 : Job({
    id("Job1")
    name = "Job 1"
})
