.386                    ; Use 32-bit instructions
.model flat, stdcall     ; Flat memory model
option casemap:none      ; Case sensitivity

includelib kernel32.lib   ; Link with kernel32 library
extern ExitProcess@4:PROC  ; Declare ExitProcess with name decoration

.data
input BYTE 1, 2, 3, 4, 5, 6, 7, 8
shift BYTE 2


.code
main PROC
	;subbrating by itself to set all registers to 0
	sub eax, eax
	sub ebx, ebx
	sub ecx, ecx
	sub edx, edx


	push 0
	call ExitProcess@4
main ENDP

END main