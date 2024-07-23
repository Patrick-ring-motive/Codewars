import kotlin.script.experimental.api.*
import kotlin.script.experimental.host.StringScriptSource
import kotlin.script.experimental.jvm.JvmScriptCompiler
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

object KotlinScriptRunner {
    private val scriptingHost = BasicJvmScriptingHost()

    fun runScript(script: String) {
        val scriptSource = StringScriptSource(script)
        val scriptDefinition = createJvmScriptDefinition<SimpleScript>()

        val result = scriptingHost.eval(scriptSource, scriptDefinition, null)

        result.reports.forEach {
            println("${it.severity}: ${it.message}")
        }
    }
}

abstract class SimpleScript(val args: Array<String>)

fun main() {
    val script = """
        fun main() {
            val number = 4
            val result = if (number % 2 == 0) "Even" else "Odd"
            println(result)
        }

        main()
    """

    KotlinScriptRunner.runScript(script)
}