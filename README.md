# CP1 — Livraria na Nuvem 📚☁️

API de catálogo de livros (Java + Spring Boot) com PostgreSQL e Docker Compose, implantada em VM Linux no Azure. O projeto demonstra containerização completa, saúde da aplicação, execução não-root, CRUD no banco e persistência via volume.

## 🎯 Objetivo

Migrar um projeto funcional para Docker Compose, orquestrando app e db com rede, variáveis de ambiente, healthcheck e persistência — e documentar o processo de deploy.

## 📋 Pré-requisitos:

- Docker e Docker Compose instalados
- Git instalado
- (Se rodar em VM) porta 3000 liberada no firewall/NSG

## ⚙️ Build & Execução:

```bash
git clone https://github.com/valor-null/CP1-LivrariaNaNuvem.git
cd CP1-LivrariaNaNuvem

# .env 

cat > .env <<'EOF'
POSTGRES_DB=livraria
POSTGRES_USER=livraria
POSTGRES_PASSWORD=supersecret
SPRING_PROFILES_ACTIVE=prod
EOF

# subir containers (build + start)
docker compose up -d --build

# health da API
curl -i http://localhost:3000/actuator/health
```
##

### 👩‍💻 Integrantes:
- 💁‍♀️ Valéria Conceição Dos Santos — RM: 557177
- 💁‍♀️ Mirela Pinheiro Silva Rodrigues — RM: 558191
