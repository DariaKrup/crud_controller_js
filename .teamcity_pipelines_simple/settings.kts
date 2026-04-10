import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.pipelines.*
import jetbrains.buildServer.configs.kotlin.triggers.ScheduleTrigger
import jetbrains.buildServer.configs.kotlin.triggers.schedule
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

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

    vcsRoot(HttpsGithubComDariaKrupBookingApiPayconiqRefsHeadsMaster)

    params {
        param("parameter", "parameter")
    }

    pipeline(CrudControllerPipeline)
    pipeline(CrudControllerPipelineSecond)
}

object HttpsGithubComDariaKrupBookingApiPayconiqRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/DariaKrup/BookingApiPayconiq#refs/heads/master"
    url = "https://github.com/DariaKrup/BookingApiPayconiq"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "DariaKrup"
        password = "credentialsJSON:a9f10039-e193-4665-afab-91b5b38ce930"
    }
    param("pipelines.connectionId", "PROJECT_EXT_238")
})


object CrudControllerPipeline : Pipeline({
    name = "CRUD Controller: pipeline"

    repositories {
        repository(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
        schedule {
            schedulingPolicy = daily {
                hour = 15
                minute = 25
            }
            triggerBuild = always()
        }
    }

    job(CrudControllerPipeline_Job1)
})

object CrudControllerPipeline_Job1 : Job({
    id("Job1")
    name = "Job 1"
})


object CrudControllerPipelineSecond : Pipeline({
    name = "CRUD Controller: pipeline (2)"

    repositories {
        repository(DslContext.settingsRoot)
    }

    triggers {
        vcs {  }
        schedule {
            schedulingPolicy = daily {
                hour = 15
                minute = 25
            }
            triggerBuild = always()
        }

        schedule {
            schedulingPolicy = weekly {
                dayOfWeek = ScheduleTrigger.DAY.Monday
                hour = 15
                minute = 15
            }
        }
    }

    job {
        id = "JobCMDId"
        name = "Job CMD"

        steps {
            script {
                scriptContent = "echo 'Success'"
            }
        }
    }
})