.PHONY : build view clean

build : accounts.py 
	-@if [ ! -e accounts ] || [ ! -f accounts ] ; then \
		cat accounts.py > accounts ;\
		chmod +x accounts ;\
	else \
		echo "\nThere's already a regular file called 'accounts', in this directory." ;\
		echo "You can use 'make clean' to remove it.\n" ;\
	fi

view : accounts.py
	@\less accounts.py

clean :  
	-@if [ -f accounts ] ; then \
		rm accounts ; \
	fi
