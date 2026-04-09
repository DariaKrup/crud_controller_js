package _Self

import _Self.vcsRoots.*
import _Self.pipelines.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({

    vcsRoot(HttpsGithubComDariaKrupBookingApiPayconiqRefsHeadsMaster)

    params {
        param("parameter", "parameter")
    }

    pipeline(CrudControllerPipeline)
})
