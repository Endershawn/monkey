PFX=emerald
NFX=orangutan
NAMES=("boots" "chestplate" "helmet" "leggings")

for NAME in "${NAMES[@]}"; do
    echo "$NFX"_"$NAME".json
    sed "s/$PFX/$NFX/g" "$PFX"_"$NAME".json > "$NFX"_"$NAME".json
done
