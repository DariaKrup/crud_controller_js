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
        copySteps(MavenTestsBuildType)
        maven {
            name = "clean test"
            goals = "clean test"
        }
    }
})

fun PipelineSteps.copySteps(buildType: BuildTypeSettings) {
    buildType.steps.items.forEach { step ->
        if (step !is PipelineCompatible) {
            return@forEach
        }

        val copy = step.copy()
        if (copy.id != null) {
            copy.id = sanitizeIdentifier(copy.id!!)
        }

        step(copy)
    }
}

fun sanitizeIdentifier(identifier: String) = identifier.replace("[^a-zA-Z0-9]".toRegex(), "_")