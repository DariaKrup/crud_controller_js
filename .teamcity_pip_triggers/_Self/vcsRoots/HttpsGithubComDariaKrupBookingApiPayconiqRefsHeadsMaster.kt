package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGithubComDariaKrupBookingApiPayconiqRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/DariaKrup/BookingApiPayconiq#refs/heads/master"
    url = "https://github.com/DariaKrup/BookingApiPayconiq"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = token {
        userName = "oauth2"
        tokenId = "tc_token_id:CID_bd894affd27faab671f2e89780bad523:-1:71347913-2e16-49a1-a1dd-9e3c6824bbab"
    }
    param("pipelines.connectionId", "PROJECT_EXT_30")
    param("tokenType", "refreshable")
})
