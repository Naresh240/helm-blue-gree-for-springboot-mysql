# helm-blue-gree-for-springboot-mysql

## Pre-Requisites

```bash
1. Install GIT
2. Install Java
3. Install Maven
4. Minikube Setup
5. Helm Install
```

## Install JAVA-8, GIT and Maven

```bash
yum install java-1.8.0-openjdk -y
yum install git -y
yum install maven -y
```
## kubernetes cluster - minikube
[minikube setup](https://github.com/Naresh240/kubernetes/blob/main/minikube-setup/README.md)

## Install helm

```bash
curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3
chmod 700 get_helm.sh
export PATH=$PATH:/usr/local/bin
./get_helm.sh
```

## Update Secret Values and Run

```bash
kubectl apply -f helm/mysql-secrets.yaml
```

# Deploy Helm Chart 

```bash
helm repo add helm-repo https://charts.bitnami.com/bitnami
helm install mysql-release helm-repo/mysql --dry-run --debug -f helm/mysql/mysql-values.yaml
helm install mysql-release helm-repo/mysql -f helm/mysql/mysql-values.yaml
```

## Build and Deploy Springboot Applcation with helm

1. Build Springboot Applocation

```bash
mvn clean install
```

2. Build and Push docker image

```bash
docker build -t naresh240/springboothello:v1 .
docker login
docker push naresh240/springboothello:v1
```

3. Deploy Springboot Application

```bash
helm install springboothello helm/springboot-example
```
## Add Record in Hostedzone under Route53
![image](https://user-images.githubusercontent.com/58024415/209925555-cc9e5f73-2df8-4e8c-861d-b03a15ec33b3.png)

## Check application in UI
![image](https://user-images.githubusercontent.com/58024415/209925428-28d35048-b8c7-46ad-96e8-aff1c92550db.png)
