package zone.ien.utils.example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform