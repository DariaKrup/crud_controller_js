package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsBbdatacenterQaTeamcityComScmTestuserMailTestDkrupkinaSimpleMavenProjectRefsHeadsMaster : GitVcsRoot({
    name = "https://bbdatacenter.qa.teamcity.com/scm/~testuser_mail.test/dkrupkina-simple-maven-project#refs/heads/master"
    url = "https://bbdatacenter.qa.teamcity.com/scm/~testuser_mail.test/dkrupkina-simple-maven-project"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = token {
        userName = "admin"
        tokenId = "tc_token_id:CID_7e24aa5c65aa16843650130d71e32905:1:1de679b8-62f0-4ea5-98af-2901ff953e84"
    }
    param("pipelines.connectionId", "PROJECT_EXT_33")
    param("tokenType", "refreshable")
})
