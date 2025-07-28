package io.github.hesamedin

interface IMPLogger  {
    fun initialize(
        platform: String,
        platformLogDirectoryPathProvider: () -> okio.Path
    )

    fun log(message: String)

}
