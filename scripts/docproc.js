const cheerio = require('cheerio');
const doc = require('fs').readFileSync('./6502 Reference.html', 'utf8');

const $ = cheerio.load(doc);

let done = false;
let current_opcode = null;

let opcodes = [];

$('body > *').each(function(i) {
    if(i < 5) return;

    if(this.name === 'hr') return done = true;

    if(!done) {
        if(this.name == 'h3') {
            if(current_opcode != null) {
                opcodes.push(current_opcode);
            }
            current_opcode = {
                mnemonic: $(this).find('a').attr('name').toLowerCase(),
                name: $(this).text().split(' - ')[1],
                description: ''
            }
        }
        current_opcode.description += $.html($(this));
    }

});

opcodes.forEach((opcode) => {
    console.log(`<opcode mnemonic="${opcode.mnemonic}" name="${opcode.name}"><description><![CDATA[${opcode.description}]]></description></opcode>`);
})