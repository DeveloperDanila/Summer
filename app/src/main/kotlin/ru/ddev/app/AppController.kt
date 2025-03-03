package ru.ddev.app

import org.slf4j.LoggerFactory
import org.springframework.http.ContentDisposition
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class AppController(private val transformService: TransformService) {

    private val log = LoggerFactory.getLogger(AppController::class.java)

    @GetMapping("/home")
    fun home(): String {
        log.info("There is no place like home...")
        return "index"
    }

    @PostMapping("/upload")
    fun upload(@RequestParam("file") file: MultipartFile): ResponseEntity<ByteArray> {
        val result = transformService.transform(file)
        val httpHeaders = HttpHeaders()
        httpHeaders.contentDisposition = ContentDisposition.builder("attachment").filename(result.filename).build()
        httpHeaders.contentType = MediaType.APPLICATION_OCTET_STREAM
        httpHeaders.contentLength = result.content.size.toLong()
        return ResponseEntity.ok()
            .headers(httpHeaders)
            .body(result.content)
    }

}