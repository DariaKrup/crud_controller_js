package _Self.pipelines

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BookingApiPayconiqPipeline : Pipeline({
    name = "BookingApiPayconiq: pipeline"

    repositories {
        repository(_Self.vcsRoots.HttpsGithubComDariaKrupBookingApiPayconiqRefsHeadsMaster)
    }

    triggers {
        vcs {
            branchFilter = "+:master*"
        }
    }

    job(BookingApiPayconiqPipeline_Job1)
})

object BookingApiPayconiqPipeline_Job1 : Job({
    id("Job1")
    name = "Job: Maven tests"

    steps {
        maven {
            name = "clean test"
            goals = "clean test"
        }
    }
})
