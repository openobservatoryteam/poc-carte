install:
	gradle assemble
	cd frontend/ && cp .env.dist .env
	cd frontend/ && npm install

format:
	gradle spotlessApply
