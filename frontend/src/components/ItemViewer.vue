<script>
export default {

  props: {

    item: {
      type: Object,
      require: true
    }

  },

  data() {
    return {}
  }

}
</script>

<template>

  <v-card
      variant="outlined"
      class=" itemViewer"
  >
    <v-card-title>{{ item.name }}</v-card-title>
    <v-card-text>
      <div><strong>ID:</strong> {{ item.id }}</div>
      <div> {{ item.description }}</div>
      <div><strong>Создан:</strong> {{ item.created }}</div>
      <div><strong>Изменен:</strong> {{ item.modified }}</div>

    </v-card-text>
    <v-card-actions>

      <v-btn
          variant="outlined"
          @click="$emit('item_edit', item)"
      >Редактировать</v-btn>
      <v-btn
          variant="outlined"
          @click="$emit('item_delete', item.id)"
      >Удалить</v-btn>

    </v-card-actions>
  </v-card>

</template>

<style>
.itemViewer {


  width: 300px;
  height: 200px;
  margin: 15px;
}
</style>