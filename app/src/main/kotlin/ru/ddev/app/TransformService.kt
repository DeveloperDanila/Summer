package ru.ddev.app

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class TransformService {

    fun transform(file: MultipartFile) : ResultDto {
        return ResultDto(ByteArray(100), "site.tar")
    }

}
