En esta version desaparece la clase PlainTextPasswordEncoder
Aparece la clase Encoder en configuration.security
En SecurityConfig cambia el passwordEnconder (desparece el bean)
En el userMapperDTO se usa este nuevo encoder
pasamos el pattern al DTO
