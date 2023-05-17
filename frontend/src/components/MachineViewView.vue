<template>

    <v-data-table
        :headers="headers"
        :items="machineView"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MachineViewView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            machineView : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/machineViews'))

            temp.data._embedded.machineViews.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.machineView = temp.data._embedded.machineViews;
        },
        methods: {
        }
    }
</script>

