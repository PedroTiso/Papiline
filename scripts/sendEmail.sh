set -e

echo "==== Enviando notificação por e-mail ===="

# Pega do ambiente (vem do GitHub Actions)
EMAIL_DESTINATARIO=$EMAIL_DEST

MENSAGEM="Pipeline executado com sucesso!"

# Envia o e-mail
echo "$MENSAGEM" | mail -s "Notificação Pipeline" "$EMAIL_DESTINATARIO"

echo "==== Notificação enviada para $EMAIL_DESTINATARIO ===="