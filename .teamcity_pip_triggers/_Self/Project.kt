package _Self

import _Self.vcsRoots.*
import _Self.pipelines.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({

    vcsRoot(HttpsGithubComDariaKrupBookingApiPayconiqRefsHeadsMaster)
    vcsRoot(HttpsBbdatacenterQaTeamcityComScmTestuserMailTestDkrupkinaSimpleMavenProjectRefsHeadsMaster)

    pipeline(BookingApiPayconiqPipeline)
    pipeline(CrudControllerPipeline)
    pipeline(SimpleMavenProjectWithoutPRs)
})
