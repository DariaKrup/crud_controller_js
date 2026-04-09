package _Self.pipelines

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object SimpleMavenProjectWithoutPRs : Pipeline({
    name = "Simple Maven Project: without PRs"

    repositories {
        repository(_Self.vcsRoots.HttpsBbdatacenterQaTeamcityComScmTestuserMailTestDkrupkinaSimpleMavenProjectRefsHeadsMaster)
    }

    triggers {
        vcs {
        }
    }

    job(SimpleMavenProjectWithoutPRs_Job1)
})

object SimpleMavenProjectWithoutPRs_Job1 : Job({
    id("Job1")
    name = "Maven tests"

    steps {
        maven {
            name = "clean test"
            goals = "clean test"
        }
    }
})
