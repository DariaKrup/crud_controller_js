import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.nodeJS
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.11"

project {

    buildType(BuildCrud)

    pipeline(CrudControllerPipeline)
    pipeline(Pipeline)
}

object BuildCrud : BuildType({
    name = "Build: CRUD"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        nodeJS {
            id = "nodejs_runner"
            shellScript = "npm run test"
        }
    }
})


object CrudControllerPipeline : Pipeline({
    name = "Crud Controller: pipeline"

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

    steps {
        script {
            name = "CMD"
            scriptContent = """echo "CRUD""""
        }
    }
})


object Pipeline : Pipeline({
    name = "Pipeline"

    repositories {
        repository(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }

    job(Pipeline_Job1)
})

object Pipeline_Job1 : Job({
    id("Job1")
    name = "Job 1"

    steps {
        script {
            scriptContent = "echo 'Pipeline'"
        }
    }
})
