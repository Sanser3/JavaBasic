javac $(FILE_NAME)
if $(EXITCODE) !=0 goto exit
java $(NAME_PART)
:exit